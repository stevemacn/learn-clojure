(ns experiment.game)

(defn get-characters []
  '("Le Chiffre" "Dr. Julius No" "Colonel von Hammerstein" "General Ourumov" "Roger Moore" "Sean Connery"  "OddJob" )
)

;called once to set the villians
;set a hash for these characters or
;return tuples (selected/not selected)
(defn get-villains [x]
  (take x (shuffle (get-characters)))
)

(defn get-suspects [x]
  (take x (shuffle (get-characters)))
)

;doesn't quite work - print line by line
(defn print-characters [xs]
  (apply println xs)
)


(defn run [x]

  (print-characters (get-villains 3) )
  (println (get-villains 3) )

)



