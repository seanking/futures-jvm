package com.rseanking.future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import org.scalatest.Matchers
import org.scalatest.WordSpec
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds,Span}

class FutureSpec extends WordSpec with Matchers with ScalaFutures {
  implicit val defaultPatience = PatienceConfig(timeout = Span(20, Seconds))
  
  "Future" should {
    "provide results for asynchronous call" in {
      
      val expectMessage = "test message"
      
      val futureMessage = Future {
        Thread.sleep(1000L)
        expectMessage
      }
      
      whenReady(futureMessage){ result =>
        result should equal(expectMessage)
      }
    }
  }
}