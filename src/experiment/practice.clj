(ns experiment.practice
  (:require [clojure.math.numeric-tower :as math]))

;trying to learn recursion
;calculate b^e recursively
(defn power [b, e]
  (cond
    (= e 0) 1
    (= e 1) b
    ;tail recursion (hopefully)
    :else (* b (power b (- e 1)))
    )
  )

(defn power-tco [c, a]
  (loop [b c e a]
    (cond
      (= e 0) 1
      (= e 1) b
      :else (recur (* b c) (- e 1))
      )
    )
  )

(defn factorial [x]
  (loop [n x f 1]
    (if (= n 1)
      f
      (recur (dec n) (* f n))
      )
    )
  )

;for practice (course) lisp tail recursion (wouldn't be optimized in clojure)
(defn fact-aux [n a]
  (if (= n 1)
    a
    (fact-aux (dec n) (* n a))
    )
  )
; must occur after fast-fact-aux otherwise it won't find the fx
(defn factorialTCO [x]
  (fact-aux x 1)
  )

;map-reduce version (not working)
;(println "map reduce factorial:" (reduce *' (range 1 5)) )

(require 'clojure.set)

;easiest most basic implementation
(defn difference [xs ys]
  ;union - join of the two sets

  (clojure.set/difference
    ;cast both lists to sets (safe for duplicate values)
    (into #{} xs)
    (into #{} ys)
  )
)

;split at length/2 turns this into merge-sort
;merge sorted lists in clojure
;not TCO in lisp or clojure
(defn merge-list [a b]
  (cond
    (empty? a) b
    (empty? b) a
    (<= (first a) (first b)) (cons (first a) (merge-list (rest a) b))
    :else (cons (first b) (merge-list a (rest b)))
    )
  )

;finding the maximum value (Lisp practice)
(defn max-list-val [x]

  (cond
    (empty? x) nil
    (empty? (rest x)) (first x)
    (< (max-list-val (rest x)) (first x)) (first x)
    :else (max-list-val (rest x))
    )
  )

(defn center [x]
  (math/floor (/ (count x) 2.0))
  )

(defn centerValue [x]
  (nth x (center x))
  )

;x is the list, y is the value we search for
(defn binary-search [x, y]
  (if (not (empty? x))
    (let [center (center x) centerValue (centerValue x)]
      ;(println "center value:" centerValue)
      ;(println "bottom" (take center x) "top" (drop center x))
      (cond
        (== centerValue y) centerValue
        (> centerValue y) (binary-search (take center x) y)
        :else (if (empty? (rest x)) nil (binary-search (drop center x) y))
        )
      )
    nil
    )
  )

;def - can receive null pointer exceptions

(defn find-missing-aux [a, b]

  (if (= (first a) nil)
    nil
    (if (= (binary-search b (first a)) nil)
      (first a)
      (find-missing-aux (rest a) b)
      )
    )
  )

(defn find-missing [a, b]
  (println a b)
  (find-missing-aux (sort a) (sort b))
  )

;currently checks if the number is the center of the list. (8 worst-case 4 touches)
;(println (binary-search '(1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18) 8))

; my haskell version
; concatMap (\x -> map (x:) $ permute $ delete x xs) xs
; #() == lambda, #{} == set - don't ever mix them up again!

(require '[clojure.math.combinatorics :as comb])

;naive approach
(defn permute-naive [xs]
  (comb/permutations #{"a" "b" "c" "d"})
  )

;lazy implementation (stolen from online)
(defn permute-lazy [s]
  (lazy-seq
    (if (seq (rest s))
      (apply concat (for [x s]
                      (map #(cons x %) (permute-lazy (remove #{x} s)))))
      [s])))


;how to indicate that remove item belongs to permute mine? namespace them?
(defn remove-item [x xs]
  (remove #{x} xs )
  )

(defn permute-mine [xs]
  (if (= (count xs) 1)  ;super inefficient - maybe use 'empty?'
    (list (seq xs))
    (mapcat #(map (partial cons %) (permute-mine (remove-item % xs))) xs)
    )
  )



(defn demo []

  (println "tail recursion (exponent):" (experiment.practice/power 2 5))
  (println "real tail recur (exponent):" (experiment.practice/power-tco 2 5))
  (println "calculate factorial" (experiment.practice/factorial 5))
  (println "calculate lisp-style TCO factorial" (experiment.practice/factorialTCO 5))

  (println "find missing element between two vectors"
           (experiment.practice/difference
             [4 1 0 2 9 6 9 7 5 3 14]
             [4 6 7 2 1 1 11 0 0 8 3 9]
             ))

  (println "merge two sorted lists" (experiment.practice/merge-list '(1 3 7 9 10 11) '(2 4 7 8)))

  (println "Maximum value in list:" (experiment.practice/max-list-val '(1 2 11 9 4 7)))

  ;8 is missing
  ;currently checks if the number is the center of the list. (8 worst-case 4 touches)
  ;(println (binary-search '(1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18) 8))
  (println "find missing element using binary search"
           (experiment.practice/find-missing '(3, 1, 2, 7, 5, 6, 8, 11, 22, 13) '(3, 1, 2, 7, 5, 11, 6, 22, 13)))


  (println "naive permutation implementation" (experiment.practice/permute-naive #{"a" "b" "c" "d"}) )
  (println "lazy permutation implementation" (experiment.practice/permute-lazy #{"a" "b" "c" "d"}) )
  (println "my permutation implementation" (experiment.practice/permute-mine #{"a" "b" "c" "d"}) )


)