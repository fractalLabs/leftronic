(ns leftronic.core
  (:use [org.danlarkin json]
        [cj shell]))

(def *key* "LfLS07rKgMGWE90GiZ8D")

(defn leftronic-curl [m] (curl :i :X "POST" :d (str "'" (encode (merge m {:accessKey *key*})) "'") "https://beta.leftronic.com/customSend/"))

(defn point [streamName point] (leftronic-curl {:streamName streamName :point point}))

(defn world-map [streamName lat long] (leftronic-curl {:streamName streamName :point {:latitude lat :longitude long}}))

(defn text-feed [streamName title msg] (leftronic-curl {:streamName streamName :point {:title title :msg msg}}))

(defn leaders [m]
  (vec (map #(hash-map :name (first %) :value (second %)) m)))

(defn leaderboard [streamName leaders-list] (leftronic-curl {:streamName streamName :point {:leaderboard (leaders leaders-list)}}))


(defn itemslist [l]
  (vec (map #(hash-map :listItem %) l)))
(defn list-widget [streamName items] (leftronic-curl {:streamName streamName :point {:list (itemslist items)}}))