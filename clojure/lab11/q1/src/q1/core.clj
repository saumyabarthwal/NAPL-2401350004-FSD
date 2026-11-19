
(println "----- JAVA INTEROPERABILITY -----")

(println "\n1. Java Static Methods")

(println "Absolute Value:" (Math/abs -25))
(println "Square Root:" (Math/sqrt 64))
(println "Current Time:" (System/currentTimeMillis))


(println "\n2. Creating Java Objects")

(def my-list (new java.util.ArrayList))

(def my-map (new java.util.HashMap))

(println "ArrayList Created:" my-list)
(println "HashMap Created:" my-map)


(println "\n3. Instance Methods")

(.add my-list "Apple")
(.add my-list "Banana")
(.add my-list "Mango")

(println "ArrayList:" my-list)
(println "First Element:" (.get my-list 0))
(println "List Size:" (.size my-list))


(.put my-map "Name" "Saumya")
(.put my-map "Age" 21)

(println "HashMap:" my-map)
(println "Name:" (.get my-map "Name"))
(println "Map Size:" (.size my-map))


(println "\n4. Collection Conversion")

(def clj-vector [10 20 30])

(def java-list
  (java.util.ArrayList. clj-vector))

(println "Clojure Vector:" clj-vector)
(println "Java ArrayList:" java-list)


(def new-clj-list
  (vec java-list))

(println "Converted Clojure Vector:" new-clj-list)

(println "\nJava Interoperability Demonstrated Successfully!")
