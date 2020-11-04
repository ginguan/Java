import java.io.*;
import java.util.Scanner;

public class AdjMatrix {

    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename){

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)){

            V = scanner.nextInt();
            adj = new int[V][V];

            E = scanner.nextInt();
            for(int i = 0; i < E; i ++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        sb.append("  0 1 2 3 4 5 6 \n");
        for(int i = 0; i < V; i ++){
            for(int j = 0; j < V; j ++){
                if(j == 0)
                {sb.append(String.format("%d ", i));}
                sb.append(String.format("%d ", adj[i][j]));}
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args){

        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.print(adjMatrix);
    }
}