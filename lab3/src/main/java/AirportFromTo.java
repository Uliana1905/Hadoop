import org.apache.spark.SparkConf;

public class AirportFromTo {
    public static void main ( String [] args){
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext ( conf);

        JavaRDD<String> lines = sc.textFile("IDandName.csv");

        


    }
}
