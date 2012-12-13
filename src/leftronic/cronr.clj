(ns leftronic.cronr
  (:use [leftronic.core json]
        [cj shell]))



(defn lee [] (map #(re-seq #"[^\t+]" %) (re-seq #"[^\n]+" (slurp "crons.txt"))))

(defn ejecuta [l] (map #(point (first %) (sh-c (second %))) l))

(defn -main []
   (let [l (lee)]
      (while true
         (do (ejecuta l)
             (sleep 60000)))))
