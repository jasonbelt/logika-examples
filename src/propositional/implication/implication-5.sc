// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def implication5(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter:off
    (p ->: r,  q ->: r)  ⊢  ((p | q) ->: r)
    Proof(
      1  (p ->: r)          by Premise,
      2  (q ->: r)          by Premise,
      3  SubProof(
        4  Assume(p | q),
        5  SubProof(
          6  Assume(p),
          7  (r)            by ImplyE(1, 6)
        ),
        8  SubProof(
          9  Assume(q),
         10  (r)            by ImplyE(2, 9)
        ),
       11  (r)              by OrE(4, 5, 8)
      ),
     12  ((p | q) ->: r)    by ImplyI(3)
    )
    //@formatter:on
  )
}
