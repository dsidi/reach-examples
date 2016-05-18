package com.yourorg

import edu.arizona.sista.processors.Sentence
import edu.arizona.sista.reach.ReachSystem
import edu.arizona.sista.reach.mentions.BioMention
import edu.arizona.sista.reach.utils.PathFinder
import scala.collection.JavaConverters._
import java.util.{List => JList}

/**
  * Created by dsidi on 1/1/16.
  */
class SimpleREACH extends ReachSystem {
  def extractFrom(text: String): JList[BioMention] = {
    extractFrom(text, "py4J", "").asJava
  }
  def get_pathfinder(sentence: Sentence): PathFinder = {
    new PathFinder(sentence)
  }
}