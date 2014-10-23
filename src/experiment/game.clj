(ns experiment.game)

(defn get-characters []
  #{"Le Chiffre" "Dr. Julius No" "Colonel von Hammerstein" "General Ourumov" "Roger Moore" "Sean Connery"  "OddJob"})

;called once to set the villians
;set a hash for these characters or
;return tuples (selected/not selected)
(defn get-suspects [x]
  (take x (shuffle (get-characters))))

;doesn't quite work - print line by line
(defn print-characters [xs]
  (apply println xs))

(defn count-occurences [xs ys]
  (if (empty? xs)
    0
    (+
      (if (contains? (set ys) (first xs)) 1 0)
      (count-occurences (rest xs) ys))))

(defn game-loop [villains z]

  (loop [x villains y (get-suspects 5) z z]

    (println "characters are" y)
    (println "villains are" x)

    (println (count-occurences x y))

    (if (= z 0) 0 (recur x (get-suspects 5) (dec z) ))
  )
)

(defn run [x]
  (game-loop (get-suspects 3) 4))



