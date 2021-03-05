# Klassendiagram für die Lösung des Damenproblems mit Hilfe von genetischen Algorithmen

@import "Klassendiagramm.mermaid"

## Dame.getFitness(damen: Dame[])

berechnet die Fitness der Dame. die Fitness sinkt für jede schlagbare Dame, die nicht sie selbst ist.

## Damee.mutate()

erzeugt einen Klon der Dame und mutiert seine Position geringfügig. 

## GeneticAlgorithm.tournament(damen: Dame[])

lässt zwei zufällige Damen gegeneinander antreten. Die mit der höheren FItess wird in die nächste Generation übernommen. Damen können nur einmal in einem Tournament antreten

