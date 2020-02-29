package com.jonyroy.sparkbasic

import com.jonyroy.sparkbasic.word.counting.WordsCounting

object SparkBasic extends SparkSessionObj {

  def main(args: Array[String]): Unit = {

    val count = WordsCounting.countWords()

    println(s"Total Words Count: ${count}")

    sparkSession.stop()

  }
}