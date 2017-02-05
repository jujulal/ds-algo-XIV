package compression

import scala.io._
import java.util.zip.{Inflater, Deflater}
import java.io.{File, FileOutputStream}

/**
  * Created by prayagupd
  * on 12/29/16.
  */

object Compression {

  def compress(inData: Array[Byte]): Array[Byte] = {
    val deflater: Deflater = new Deflater()
    deflater.setInput(inData)
    deflater.finish
    val compressedData = new Array[Byte](inData.size * 2) // compressed data can be larger than original data
    val count: Int = deflater.deflate(compressedData)
    return compressedData.take(count)
  }

  def decompress(inData: Array[Byte]): Array[Byte] = {
    val inflater = new Inflater()
    inflater.setInput(inData)
    val decompressedData = new Array[Byte](inData.size * 2)
    var count = inflater.inflate(decompressedData)
    var finalData = decompressedData.take(count)
    while (count > 0) {
      count = inflater.inflate(decompressedData)
      finalData = finalData ++ decompressedData.take(count)
    }
    return finalData
  }

  def main(args: Array[String]) = {
    val inFile = "src/main/resources/data.log"
    val outFile = "src/main/resources/compressed.log"
    var lines = Source.fromFile(inFile).getLines.toIterable
    var count = 0
    while (lines.size > 0) {
      val compressedBytes = compress(lines.take(10).mkString("\n").getBytes)
      lines = lines.drop(10)
      count += 1
      (new FileOutputStream(new File(outFile + count))).write(compressedBytes)
    }
  }
}
