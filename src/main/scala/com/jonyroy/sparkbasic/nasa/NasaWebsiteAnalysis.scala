package com.jonyroy.sparkbasic.nasa

import com.jonyroy.sparkbasic.SparkSessionObj
import com.jonyroy.sparkbasic.utils.DataDirectory
import org.apache.spark.sql.{Dataset, Encoder}

object NasaWebsiteAnalysis extends SparkSessionObj {

  def getNasaWeb[T <: Product: Encoder]: Dataset[T] = {

    sparkSession
      .read
      .option("header", true)
      .option("sep", " ")
      .csv(inputPath)
      .as[T]
  }

  private def inputPath: String = DataDirectory.getDataDir + "nasa" + "/*"

}
