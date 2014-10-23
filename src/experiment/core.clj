(ns experiment.core
  (
   :use [experiment.game]
   :use [experiment.practice]
  ))

; author: stephen macneil
; problems: power, powerTCO, factorial, factorialTCO,

(defn -main [& args]
  (println "Working!"))



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



