(ns App
  (:require
   ["preact" :as react]
   ["xstream$default" :as xs]
   ["@cycle/run" :refer [run]]
   ["@cycle/dom" :refer [makeDOMDriver]]))

(defn main []
  {:DOM (-> xs
            (.periodic 1000)
            (.map #(#jsx [:h1 (str % " hello seconds elapsed")])))})

(run main {:DOM (makeDOMDriver "#mount")})
