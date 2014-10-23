(ns experiment.game)

(defn get-characters []
  #{"Le Chiffre" "Dr. Julius No" "Colonel von Hammerstein" "General Ourumov" "Roger Moore" "Sean Connery"  "OddJob"})

;Get Suspects: get x random characters from the pool of characters.
(defn get-suspects [x]
  (take x (shuffle (get-characters))))

;doesn't quite work - print each item line by line
(defn print-characters [xs]
  (apply println xs))

;Count Occurences: count the number of villains that are present in the list of suspects
(defn count-occurences [xs ys]
  (if (empty? xs)
    0
    (+
      (if (contains? (set ys) (first xs)) 1 0)
      (count-occurences (rest xs) ys))))

;Game Loop: keeps the villains the same and updates the suspects to display a different number each time.
(defn game-loop [villains z]

  (loop [x villains y (get-suspects 5) z z]

    (println "characters are" y)
    (println "villains are" x)

    (println (count-occurences x y))

    (if (= z 0) 0 (recur x (get-suspects 5) (dec z) ))
  )
)

(defn run [x]
  ;<- here we allow people to start playing register
  ;the number of players and pass that to the game loop
  (game-loop (get-suspects 3) 4))


;open questions
;
; how do we break out of the game loop on game end (win or lose)?




