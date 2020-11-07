import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class AirportFromTo {
    private static final String FIRSTLINE = "Code,Description";
    private static final String REPLACEABLE = "\"";
    private static final String REPLACEMENT = "";

    public static void main ( String [] args){
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext ( conf);

        JavaRDD<String> fileWithAirports = sc.textFile("IDandName.csv");

        JavaRDD<String> airports = fileWithAirports.map(s-> s.replaceAll(REPLACEABLE, REPLACEMENT)).filter(s-> !s.equals(FIRSTLINE));

        




    }
}
