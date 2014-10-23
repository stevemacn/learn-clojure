(ns experiment.core
  (
   :use [experiment.game]
   :use [experiment.practice]
  ))

; author: stephen macneil
; problems: power, powerTCO, factorial, factorialTCO,

(defn -main [& args]
  (println "Working!"))

;(experiment.practice/demo)
  (experiment.game/run 1)