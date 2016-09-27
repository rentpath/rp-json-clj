(ns rp.json.graph
  "JSON Graph utilities"
  (:refer-clojure :exclude [ref]))

(defn ref
  [value]
  {:$type :ref
   :value value})
