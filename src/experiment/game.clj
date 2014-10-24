(ns experiment.game)

;======Character utilities====
(defn get-characters []
  #{"Le Chiffre" "Dr. Julius No" "Colonel von Hammerstein" "General Ourumov" "Roger Moore" "Sean Connery"  "OddJob"})

;Get Suspects: get x random characters from the pool of characters.
(defn get-suspects [x]
  (take x (shuffle (get-characters))))

;doesn't quite work - print each item line by line
(defn print-characters [xs]
  (apply println xs))

;Remove item: returns a list with the specified item removed
(defn remove-character [x xs]
  (remove #{x} xs ))

;Count Occurences: count the number of villains that are present in the list of suspects
(defn count-occurences [xs ys]
  (if (empty? xs)
    0
    (+
      (if (contains? (set ys) (first xs)) 1 0)
      (count-occurences (rest xs) ys))))

;======Recursive game loop====

(defn print-game-state [x y user]
  (println "The characters are" y)
  (println (count-occurences x y) "are villains!")
  (println (first user) "- who is the double-agent? Type skip if you don't know")
)

;Game Loop: keeps the villains the same and updates the suspects to display a different number each time.
(defn game-loop [villains users]

  (print "Welcome players! ")
  (print-characters users)

  ;initialize the recursive game loop
  (loop [x villains y (get-suspects 5) player1 (last users), users users]
    (print-game-state x y users)

    ;take command from user and check to see if they win or loose
    (let [line (read-line)]
      (if (not (= line "skip"))
        (if (contains? (set x) line)
          (do
            (println (first users) "burned double agent" line)
            (if (empty? (butlast x) )
              (println (first users) "wins!")
              (recur (remove-character line x) (if (= (first users) player1) (get-suspects 5) y )  player1 (cons (last users) (butlast users)))
            )
          )
          (do
            (println (first users) "is now missing in action")
            (if (empty? (butlast users))
              (println "All players are missing in action - game over.")
              (recur x (if (= (first users) player1) (get-suspects 5) y )  player1 (rest users))
            )
          ))
          (recur x (if (= (first users) player1) (get-suspects 5) y )  player1 (cons (last users) (butlast users)))
        ))))

;======Initialize the game====
; Run: set up the number of players and start the game loop.
(defn run [x]
  (println "Please type the name for each player (press only enter to start playing)")

  (loop [x '()]
    (let [line (read-line)]
      (if (= line "")
        (game-loop (get-suspects 3) x))
        (recur (concat x (list line)))
    )
  )
)

