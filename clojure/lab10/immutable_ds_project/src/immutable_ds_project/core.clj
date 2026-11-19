;; 1. LIST
(println "\n----- LIST -----")

(def my-list '(10 20 30))

(println "Original List:" my-list)
(println "First Element:" (first my-list))
(println "Rest of List:" (rest my-list))

(def new-list (conj my-list 5))

(println "New List after conj:" new-list)
(println "Original List unchanged:" my-list)


;; 2. VECTOR
(println "\n----- VECTOR -----")

(def my-vector [10 20 30])

(println "Original Vector:" my-vector)

(def new-vector (conj my-vector 40))

(println "New Vector after conj:" new-vector)
(println "Element at Index 1:" (get my-vector 1))
(println "Count:" (count my-vector))
(println "Original Vector unchanged:" my-vector)


;; 3. MAP
(println "\n----- MAP -----")

(def my-map {:name "Saumya" :age 21})

(println "Original Map:" my-map)

(def new-map (assoc my-map :city "Gurgaon"))

(println "New Map after assoc:" new-map)

(def updated-map (dissoc my-map :age))

(println "New Map after dissoc:" updated-map)

(println "Get Name:" (get my-map :name))
(println "Original Map unchanged:" my-map)


;; 4. SET
(println "\n----- SET -----")

(def my-set #{10 20 30})

(println "Original Set:" my-set)

(def new-set (conj my-set 40))

(println "New Set after conj:" new-set)

(def updated-set (disj my-set 20))

(println "New Set after disj:" updated-set)

(println "Contains 10:" (contains? my-set 10))
(println "Original Set unchanged:" my-set)


;; CONCLUSION
(println "\nAll four immutable data structures demonstrated successfully!")