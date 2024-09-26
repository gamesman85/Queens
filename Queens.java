public class Queens {
    public final int max = 8;
    public int[] place = new int[max];

    private boolean legal(int r, int c) {
        for (int x = 0; x < r; ++x) {
            int y = place[x];
            if (y == c) return false; // same column
            if (x - y == r - c) return false; // same diagonal
            if (x + y == r + c) return false; // same diagonal
        }
        return true; // No conflicts found
    }

    public boolean placement(int r) {
        if (r == max) return true; // All queens are placed
        for (int c = 0; c < max; ++c) {
            if (legal(r, c)) {
                place[r] = c; // Place queen
                if (placement(r + 1)) return true; // Recur to place next queen
            }
        }
        return false; // No valid position found for this row
    }

    public static void main(String[] args) {
        Queens q = new Queens();
        boolean found = q.placement(0);
        if (found) {
            for (int i = 0; i < q.max; ++i) {
                System.out.print("(" + i + ", " + q.place[i] + ") ");
            }
            System.out.println();   
        } else {
            System.out.println("No solution found");
        }
    }
}