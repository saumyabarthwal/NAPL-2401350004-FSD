
(def numbers1 [1 2 3 4 5 6 7 8])

(println "----- First Collection -----")
(println "Original Collection:" numbers1)


(println "Squares:" (map #(* % %) numbers1))


(println "Even Numbers:" (filter even? numbers1))


(println "Sum:" (reduce + numbers1))


(println "First 3 Elements:" (take 3 numbers1))
(println "After Dropping 3 Elements:" (drop 3 numbers1))


(println "Chained Result:"
         (->> numbers1
              (filter even?)
              (map #(* % %))
              (take 2)))



(def numbers2 [10 15 20 25 30 35])

(println "\n----- Second Collection -----")
(println "Original Collection:" numbers2)


(println "Squares:" (map #(* % %) numbers2))

;; FILTER
(println "Numbers Greater Than 20:" (filter #(> % 20) numbers2))

;; REDUCE
(println "Maximum Number:" (reduce max numbers2))

;; TAKE and DROP
(println "First 2 Elements:" (take 2 numbers2))
(println "After Dropping 2 Elements:" (drop 2 numbers2))

;; Threading Macro ->>
(println "Chained Result:"
         (->> numbers2
              (filter #(> % 15))
              (map #(+ % 5))
              (take 3)))
