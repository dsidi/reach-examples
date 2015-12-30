package com.yourorg

<<<<<<< HEAD
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths, Path}
=======
import scala.io.Source

import edu.arizona.sista.reach._
>>>>>>> e5124e2e682f239a4d4eadd77e177b32ac508ff7
import edu.arizona.sista.reach.grounding._
import scala.io.Source

/**
<<<<<<< HEAD
  * Lookup grounding information for each string in a list of strings.
  * Author: Tom Hicks. 12/13/2015. Modified by David Sidi (30 Dec 2015).
  * Last Modified: Split into class and object for py4j. Added resolution from file. (dsidi)
  */
class GroundStrings {
=======
 * Lookup grounding information for each string in a list of strings.
 * Author: Tom Hicks. 12/13/2015.
 * Last Modified: Update to optionally read model or use strings from standard input.
 */
object GroundStrings extends App {
>>>>>>> e5124e2e682f239a4d4eadd77e177b32ac508ff7

  /** Specify the lookup tables to be loaded and the order in which they are searched. */
  val searchSequence =
    Seq(
      new StaticProteinFamilyKBLookup,
      new StaticProteinKBLookup,
      new StaticChemicalKBLookup,
      new StaticMetaboliteKBLookup,
      new StaticCellLocationKBLookup
    )

  /** A sample set of strings to be resolved by the grounding machinery. */
  val model = List("erk1", "RAS", "vanadocene", "eta-Tocopherol", "cell body", "NOT-IN-KB")

  /** Search the sequence of KBs for the given string, returning an optional tuple
      of KB namespace and reference ID, if a KB entry with the given key was found. */
  def resolveString(aString: String): Option[Tuple2[String, String]] = {
    println(s"ENTRY: $aString")
    searchSequence.foreach { kbLookup => // for each KB in the sequence
      val refID = kbLookup.resolve(aString) // lookup the given string key
      if (!refID.isEmpty) // if an entry with that key is found in a KB
        return Some(Tuple2(kbLookup.namespace, refID.get)) // then return KB namespace and ID value
    var a = Some(Tuple1("foo"))
    }
    return None // else signal failure to find key string in any KB
  }

  /** Resolves entity names appearing in pairs in a TSV file, and outputs to a file. */
  def resolveFromFile(path: String) = {
    val grounded_names = Source.fromFile(path).getLines().flatMap { line =>
      line.split('\t').map { entry =>
        println(s"ENTRY: $entry")
        resolveString(entry)
      }
    }
    Files.write(
      Paths.get("grounded_entity_names.tsv"),
      grounded_names.mkString("\t").getBytes(StandardCharsets.UTF_8)
    )
  }
}

object GroundStrings extends App {

  val grounder = new GroundStrings()

<<<<<<< HEAD
  /** A sample set of strings to be resolved by the grounding machinery. */
  val model = List("erk1", "RAS", "vanadocene", "eta-Tocopherol", "cell body", "NOT-IN-KB")

  // try to resolve each of the strings in the model:
  model.foreach { str =>
    val resolved = grounder.resolveString(str)
=======
  /** Try to resolve the given string and print the result of attempt. */
  def resolveAndPrint (str: String): Unit = {
    val resolved = resolveString(str)
>>>>>>> e5124e2e682f239a4d4eadd77e177b32ac508ff7
    if (resolved.isEmpty)
      println(s"String '${str}' => NOT FOUND")
    else
      println(s"String '${str}' => ${resolved.get._1}(${resolved.get._2})")
  }
<<<<<<< HEAD
=======

  /** Try to resolve each of the strings in the sample model. */
  def doSampleModel (): Unit = {
    model.foreach(resolveAndPrint(_))
  }

  // Main method: resolve model strings or resolve each line of standard input
  var lineCount = 0
  val start = java.lang.System.currentTimeMillis()
  if (!args.isEmpty && args(0) == "model") {
    lineCount = model.size
    doSampleModel
  }
  else
    for (line <- io.Source.stdin.getLines) {
      resolveAndPrint(line)
      lineCount += 1
    }
  val stop = java.lang.System.currentTimeMillis()
  println(s"Resolution time for ${lineCount} lines: ${stop - start}ms")
>>>>>>> e5124e2e682f239a4d4eadd77e177b32ac508ff7
}

