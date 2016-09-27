(ns rp.json.graph-test
  (:refer-clojure :exclude [ref])
  (:require [clojure.test :refer :all]
            [clojure.spec :as s]
            [clojure.spec.test :as stest]
            [rp.json.graph :refer :all]))

(s/def :json-graph-ref/$type #{:ref})
(s/def ::value any?)
(s/def ::ref (s/keys :requn [:json-graph-ref/$type ::value]))

(s/fdef rp.json.graph/ref
        :args (s/cat :value any?)
        :ret (fn []))
(stest/instrument 'rp.json.graph/ref)

(deftest test-ref
  (is (= {:$type :ref
          :value 42}
         (ref 42)))
  (is (= {:$type :ref
          :value nil}
         (ref nil))))
