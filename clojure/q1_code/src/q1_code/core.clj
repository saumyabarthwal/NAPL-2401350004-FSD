(ns q1_code.core
  (:require [next.jdbc :as jdbc]
            [ring.adapter.jetty :as jetty]))

//dataset
(def students
  [{:name "Saumya" :marks 95}
   {:name "Manju" :marks 85}
   {:name "Parneet" :marks 75}
   {:name "Rashi" :marks 67}
   {:name "Bhavii" :marks 40}
   {:name "Shreyas" :marks 47}])


(def passed-students
  (filter #(>= (:marks %) 40) students))


(def processed-students
  (map #(assoc % :result "Pass") passed-students))


(def total-marks
  (reduce + 0 (map :marks processed-students)))

(println "Processed Students:" processed-students)
(println "Total Marks:" total-marks)




(def db
  (jdbc/get-datasource
   {:dbtype "sqlite"
    :dbname "students.db"}))

(jdbc/execute! db
  ["CREATE TABLE IF NOT EXISTS students
    (id INTEGER PRIMARY KEY AUTOINCREMENT,
     name TEXT,
     marks INTEGER,
     result TEXT)"])


(defn save-to-database []
  (try
    (doseq [student processed-students]
      (jdbc/execute! db
        ["INSERT INTO students (name, marks, result)
          VALUES (?, ?, ?)"
         (:name student)
         (:marks student)
         (:result student)]))

    (println "Data saved successfully!")

    (catch Exception e
      (println "Database Error:" (.getMessage e)))))




(defn read-from-database []
  (try
    (let [records
          (jdbc/execute! db
            ["SELECT * FROM students"])]
      (println "Records from Database:")
      (doseq [record records]
        (println record))
      records)

    (catch Exception e
      (println "Database Read Error:" (.getMessage e))
      [])))




(defn app [request]
  (if (= "/" (:uri request))
    {:status 200
     :headers {"Content-Type" "text/plain"}
     :body (str "Processed Student Data:\n"
                (pr-str processed-students)
                "\nTotal Marks: "
                total-marks)}

    (if (= "/students" (:uri request))
      {:status 200
       :headers {"Content-Type" "text/plain"}
       :body (str (pr-str (read-from-database)))}

      {:status 404
       :headers {"Content-Type" "text/plain"}
       :body "Page Not Found"})))




(defn -main []
  (save-to-database)
  (read-from-database)

  (println "Server started at http://localhost:3000")

  (jetty/run-jetty app {:port 3000}))