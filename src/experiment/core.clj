(ns experiment.core
  (:require [clojure.math.numeric-tower :as math])
)

; author: stephen macneil
; problem: find the missing element in a set of numbers


(defn -main [& args]
  (println "Working!"))

;trying to learn recursion
;calculate b^e recursively
(defn power [b, e]
  ;(println b e)

  (cond
    (= e 0) 1
    (= e 1) b
    ;tail recursion (hopefully)
    :else (* b (power b (- e 1)))
  )
)

(defn power2 [c, a]
  (loop [b c e a]
    ;(println b e)
    (cond
      (= e 0) 1
      (= e 1) b
      :else (recur (* b c) (- e 1))
    )
  )
)

(println "tail recursion (exponent):" (power 2 5))
(println "real tail recur (exponent):" (power2 2 5))

(defn factorial [x]
  (loop [n x f 1]
    (if (= n 1)
      f
      (recur (dec n) (* f n))
    )
  )
)
(println (factorial 5))


;for practice (course) lisp tail recursion (wouldn't be optimized in clojure)
(defn fact-aux [n a]
  (if (= n 1)
      a
      (fact-aux (dec n) (* n a))
  )
)
; must occur after fast-fact-aux otherwise it won't find the fx
(defn fact [x]
  (fact-aux x 1)
)

(println (fact 5))

;map-reduce version (not working)
;(println "map reduce factorial:" (reduce *' (range 1 5)) )

;probably the easiest way to find the missing element
(require 'clojure.set )

(println
  ;union - join of the two sets
  (clojure.set/difference
    ;cast both lists to sets (safe for duplicate values)
    (into #{} [4 1 0 2 9 6 9 7 5 3 14])
    (into #{} [4 6 7 2 1 1 11 0 0 8 3 9])
    )
  )

