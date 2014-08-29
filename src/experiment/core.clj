(ns experiment.core)

; author: stephen macneil
; problem:


(defn -main [& args]
  (println "Working!"))

(defn foo [x]
  (println x)
  (println (sort x))
  )

(println ( foo '(2 4 1 5 3 9 6 8 10 7)))

