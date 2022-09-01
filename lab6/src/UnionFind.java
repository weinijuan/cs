public class UnionFind {
    private int[] ar;
    public UnionFind(int n)
    {
        ar = new int[n];
        for (int i = 0; i < n; i++)
        {
            ar[i] = -1;
        }
    }

    public void validate(int v1) throws IndexOutOfBoundsException
    {

        if (v1 < 0 || v1 >= ar.length)
        {
            throw new IndexOutOfBoundsException("error index");
        }
    }

    public int sizeOf(int v1)
    {
        return -ar[find(v1)];
    }
    public int parent(int v1)
    {
        return ar[v1];
    }
    public int find(int v1)
    {
        int temp = v1;
        if (ar[v1] >= 0)
        {
            v1 = ar[v1];
        }
        while (ar[v1] >= 0)
        {
            ar[temp] = v1;
            temp = v1;
            v1 = ar[v1];
        }
        return v1;
    }
    public boolean connected(int v1, int v2)
    {
        return find(v1) == find(v2);
    }
    public void union(int v1, int v2)
    {
        if (sizeOf(v1) <= sizeOf(v2))
        {
            ar[find(v2)] += ar[find(v1)];
            ar[find(v1)] = find(v2);
        }
        else
        {
            ar[find(v1)] += ar[find(v2)];
            ar[find(v2)] = find(v1);
        }
    }

}
/**
 * public UnionFind(int n): Creates a UnionFind data structure holding n vertices. Initially, all vertices are in disjoint sets.
 * public void validate(int v1): Throws an exception if v1 is not a valid index.
 * public int sizeOf(int v1): Returns the size of the set v1 belongs to.
 * public int parent(int v1): Returns the parent of v1. If v1 is the root of a tree, returns the negative size of the tree for which v1 is the root.
 * public boolean connected(int v1, int v2): Returns true if nodes v1 and v2 are connected.
 * public void union(int v1, int v2): Connects two elements v1 and v2 together. v1 and v2 can be any valid elements, and a union-by-size heuristic is used. If the sizes of the sets are equal, tie break by connecting v1’s root to v2’s root. Unioning a vertex with itself or vertices that are already connected should not change the sets, but it may alter the internal structure of the data structure.
 * public int find(int v1): Returns the root of the set v1 belongs to. Path-compression is employed allowing for fast search-time.*/