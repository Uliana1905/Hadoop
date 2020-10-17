package bmstu.flight;

public class FlightJob {
    JobConf conf = new JobConf(JoinJob.class);
    conf.setJobName("map join");
    conf.setInputFormat(CompositeInputFormat.class);
    FileOutputFormat.setOutputPath(conf, new Path(args[2]));
    conf.set("mapred.join.expr", CompositeInputFormat.compose("inner",
        KeyValueTextInputFormat.class,
        args[0],
        args[1]
            ));
    conf.setMapperClass(MapJoinMapper.class);
    conf.setOutputKeyClass(Text.class);
    conf.setOutputValueClass(Text.class);
    JobClient.runJob(conf);
}


