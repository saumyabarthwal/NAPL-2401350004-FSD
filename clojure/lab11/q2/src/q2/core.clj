(println "----- EXCEPTION HANDLING -----")



(println "\n1. Arithmetic Exception")

(try
  (println "Result:" (/ 10 0))

  (catch ArithmeticException e
    (println "Error:" (ex-message e)))

  (finally
    (println "Arithmetic operation completed.")))


(println "\n2. Null Pointer Exception")

(try
  (let [x nil]
    (.length x))

  (catch NullPointerException e
    (println "Error: Null value found!"))

  (finally
    (println "Null checking completed.")))




(defn check-age [age]
  (if (< age 18)
    (throw (ex-info "Age must be 18 or above!"
                    {:age age
                     :error "Underage"}))
    "You are eligible."))


(println "\n3. Custom Exception")

(try
  (println (check-age 15))

  (catch clojure.lang.ExceptionInfo e
    (println "Error Message:" (ex-message e))
    (println "Error Details:" (ex-data e))
    (println "Recovering gracefully..."))

  (finally
    (println "Age checking completed.")))


(println "\nException Handling Demonstrated Successfully!")