(ns App
  (:require
   ["xstream$default" :as xs]
   ["@cycle/run" :refer [run]]
   ["@cycle/dom" :refer [makeDOMDriver h1]]))

(defn main []
  {:DOM (-> xs
            (.periodic 1000)
            (.map #(h1 (str % " hello seconds elapsed"))))})

(run main {:DOM (makeDOMDriver "#mount")})
