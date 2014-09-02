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

(power 3 2)d
