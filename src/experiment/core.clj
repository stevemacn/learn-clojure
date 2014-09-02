(ns experiment.core)

; author: stephen macneil
; problem:


(defn -main [& args]
  (println "Working!"))

;trying to learn recursion
;calculate b^e recursively
(defn power [b, e]
  (println b e)

  (cond
    (= e 0) 1
    (= e 1) b
    ;tail recursion (hopefully)
    :else (* b (power b (- e 1)))
  )
)

(defn power2 [c, a]
  (loop [b c e a]
    (println b e)
    (cond
      (= e 0) 1
      (= e 1) b
      :else (recur (* b c) (- e 1))
    )
  )
)


(println "tail recursion (exponent):" (power 2 5))
(println "real tail recur (exponent):" (power2 2 5))

