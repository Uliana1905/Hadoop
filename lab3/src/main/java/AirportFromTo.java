import org.apache.spark.SparkConf;

import java.util.Arrays;

public class AirportFromTo {
    public static void main ( String [] args){
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext ( conf);

        JavaRDD<String> fileWithAirports = sc.textFile("IDandName.csv");

        JavaRDD<String> airports = fileWithAirports.FlatMap( s-> s.replace("\"","")).filter(s-> !)



    }
}
