package com.yourorg
import edu.arizona.sista.reach.ReachSystem
import py4j.GatewayServer
import scala.collection.JavaConverters

/**
  * Provide an entry point for py4J (python-scala interop).
  * Author: David Sidi (30 Dec 2015)ec
  * Last Modified: Created.
  */
object GroundStringsEntryPoint extends App{
    def getReachSystem() = new SimpleREACH()
    def getGroundStrings() = new GroundStrings()
    def getAsJava() = JavaConverters
    var gatewayServer = new GatewayServer(GroundStringsEntryPoint)
    gatewayServer.start()
    println("Started gateway server for REACH ... ")
}
