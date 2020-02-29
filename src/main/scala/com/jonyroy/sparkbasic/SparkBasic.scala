package com.jonyroy.sparkbasic

import com.jonyroy.sparkbasic.nasa.NasaWebsiteAnalysis
import com.jonyroy.sparkbasic.schema.NasaWebsite
import com.jonyroy.sparkbasic.word.counting.WordsCounting

object SparkBasic extends SparkSessionObj {

  def main(args: Array[String]): Unit = {

    import sparkSession.implicits._


    NasaWebsiteAnalysis.getNasaWeb[NasaWebsite]

    sparkSession.stop()

  }
}