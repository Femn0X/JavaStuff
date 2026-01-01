import java.util.Arrays;
public class Vector{
    double[][] vector;
    Vector(double[][] vect){
        this.vector=vect;
    }
    double[][] getVector(){
        return this.vector;
    }
    Vector add(Vector other){
        double[][] re=new double[this.vector.length][this.vector[0].length];
        for (int i=0;i<this.vector.length;i++){
            for (int j=0;j<this.vector[0].length;j++){
                re[i][j]=this.vector[i][j]+other.vector[i][j];
            }
        }
        return new Vector(re);
    }
    Vector sub(Vector other){
        double[][] re=new double[this.vector.length][this.vector[0].length];
        for (int i=0;i<this.vector[0].length;i++){
            for (int j=0;j<this.vector[0].length;j++){
                re[i][j]=this.vector[i][j]-other.vector[i][j];
            }
        }
        return new Vector(re);
    }
    Vector mul(Vector other){
        double[][] re=new double[this.vector.length][this.vector[0].length];
        for (int i=0;i<this.vector[0].length;i++){
            for (int j=0;j<this.vector[0].length;j++){
                re[i][j]=this.vector[i][j]*other.vector[i][j];
            }
        }
        return new Vector(re);        
    }
    @Override
    public String toString(){
        return Arrays.deepToString(this.vector);
    }
}
