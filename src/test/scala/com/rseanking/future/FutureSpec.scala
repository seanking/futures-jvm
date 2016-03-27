package com.rseanking.future

import org.scalatest.WordSpec
import org.scalatest.Matchers
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}
import scala.util.Success
import scala.util.Failure

class FutureSpec extends WordSpec with Matchers with ScalaFutures {
  implicit val defaultPatience = PatienceConfig(timeout = Span(20, Seconds))
  
  "Future" should {
    "provide results for asynchronous call" in {
      
      val expectMessage = "test message"
      
      
      val f = Future {
        Thread.sleep(4000)
        expectMessage
      }
      
      whenReady(f){ result =>
        result should equal(expectMessage)
      }
    }
  }
}