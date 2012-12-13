(ns leftronic.cronr
  (:use [leftronic.core ]
        [cj shell]))



(defn lee [] (map #(re-seq #"[^\t]+" %) (re-seq #"[^\n]+" (slurp "crons.txt"))))

(defn ejecuta [l] (doall (map #(point (first %) (re-find #"\d+" (sh-c (second %)))) l)))

(defn -main
  ([seconds]
   (let [l (lee)]
         (while true
           (do (ejecuta l)
             (sleep seconds)))))
  ([]
   (-main 60)))
