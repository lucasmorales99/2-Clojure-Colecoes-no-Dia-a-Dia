(ns loja.aula3
  (:require [loja.db :as l.db]))

(println (l.db/todos-os-pedidos))

(println (group-by :usuario (l.bd/todos-os-pedidos)))       ;está agrupando todos os usuarios dentro de pedidos

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

(println (group-by minha-funcao-de-agrupamento (l.db/todods-os-pedidos)))


; { 15 [x,c,y]
;   1  [x]
;   10 [x]
;   20 [x,2]}

(println (count (vals (group-by :usuario (l.db/todods-os-pedidos))))) ;nesse a resposta é 4 pois temos 4 usuarios

(println (map count (vals (group-by :usuario (l.db/todods-os-pedidos))))) ;nesse ele me devolve o numero de compras dentro de cada usuario (3 1 1 1), como o usuario 15 qu é o primeiro ele tem 3 vendas

;com thread last
(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     vals (map count)
     println)

(defn conta-total-por-usuario
  [[usuario pedidos]]
  [usuario (count pedidos)])

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)


(defn contaa-total-por-usuario
  [[usuario pedidos]]
  {
   :usuario-id usuario
   :total-de-pedidos (count pedidos)
   })

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

;---------
(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  {
   :usuario-id usuario
   :total-de-pedidos (count pedidos)
   })

















