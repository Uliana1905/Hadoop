mvn package

hadoop fs -copyFromLocal IDandTime.csv /

hadoop fs -copyFromLocal IDandName.csv /

spark-submit --class ru.bmstu.sparkLab.AirportFromTo --master yarn-client --num-executors 3 target/spark-examples-1.0-SNAPSHOT.jar

hadoop fs -copyToLocal output

