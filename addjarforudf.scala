spark-shell --jars path-to-jar #paths can be hdfs path or local file path

val sqlContext = new org.apache.spark.sql.hive.HiveContext(sc);

sqlContext.sql("""create temporary function function_name as 'com.github.gbraccialli.hive.udf.FunctionClassPath'""");

val res = sqlContext.sql(" Valid Hive SQL Statement Here ").collect();
