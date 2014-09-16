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

;merge sorted lists in clojure
(defn merge-list [a b]

    (println a b)

    (cond
      (empty? a) b
      (empty? b) a
      (<= (first a) (first b))  (cons (first a) (merge-list (rest a) b))
      :else  (cons (first b) (merge-list a (rest b)))
    )
)

(println (merge-list '(1 3 7 9 10 11) '(2 4 7 8)))

;finding the maximum value (Lisp practice)
(defn max-list-val [x]

  (cond
    (empty? x) nil
    (empty? (rest x)) (first x)
    (< (max-list-val (rest x)) (first x)) (first x)
    :else (max-list-val (rest x))
  )
)

(println "Maximum value in list:" (max-list-val '(1 2 11 9 4 7)))

