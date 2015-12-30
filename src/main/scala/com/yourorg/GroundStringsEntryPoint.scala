package com.yourorg
import py4j.GatewayServer

/**
  * Provide an entry point for py4J (python-scala interop).
  * Author: David Sidi (30 Dec 2015).
  * Last Modified: Created.
  */
object GroundStringsEntryPoint extends App{
    def getGroundStrings() = GroundStrings
    var gatewayServer = new GatewayServer(GroundStringsEntryPoint)
    gatewayServer.start()
    println("Started gateway server for GroundStrings... ")
}



