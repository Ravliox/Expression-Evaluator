# Expression-Evaluator
Expression interpreter and evaluator using Abstract Syntax Trees

Pentru inceput, vom citi fisierul si il vom pasa clasei Expression sub forma unui string. In constructorul acesteia vom parcurge
stringul si atunci cand vom intalni o valoare sau un simbol il vom pune intr-o stiva, iar atunci cand intalnim un operator, cream 
tipul corespunzator si dam pop din stiva la cate elemente trebuie ca acesta sa aiba (Ex: pentru add vom da pop de 2 ori, si astfel
stim ca vom avea argumentele necesare), urmand ca acesta sa fie apoi introdus in stiva la randul lui, pentru a fi introdus in 
lista de copii a altor noduri.

Pentru formarea de noduri, folosim Design Pattern factory si o clasa Symbols. Symbols va avea un vector de Stringuri, si va avea o 
functie ce va identifica indexul acestora. Daca nu il gaseste atunci va returna -1, semnaland ca este vorba de o valoare sau de un 
simbol. NodeFactory va lua operatorul citit din fisier, si va apela Symbols.findIndex() pe acesa si va crea nodul corespunzator.

Pentru implementarea nodurilor se foloseste o clasa abstracta Node, ce va avea un constructor ce ii va initializa lista de argumente, 
care va fi apelat din fiecare nod cu super (numar de noduri din lista de copii). De asemenea Node are o metoda abstracta accept (
visitor), folosita pentru abstractizarea Nodurilor, si visitarea lor de catre visitor. Rezultatul intors de acesta va fi codificat ca 
si int. Unele clase nu ne intereseaza ce returneaza, ex ReturnNode sau NothingNode. Asa ca putem returna orice. Pentru expresiile 
boolene vom returna 1 pentru true si 0 pentru false.

Astfel, pentru a accesa valorile returnate de un nod, tot ce trebuie sa facem e sa dam accept(visitor) pe ele.

ArgumentNode va returna valoarea din interior. Pentru simboluri folosim un hashMap cu cheia simbolulul si valoarea data in argument, 
se va returna valoarea de acolo.

AddNode va returna suma celor 2 argumente. visit pe el, va apela accept pe copii lui, accepturile returnand valorile, si le va aduna.

MultiplyNode idem mai sus doar ca le va inmulti.

LessNode, EqualsNode, idem mai sus doar ca le compara corespunzator. 

AssignNode, va lua simbolul direct din primul argument, deoarece accept pe acesta va verifica daca exista in tabela de valori deja ceea
ce s-ar putea sa dea eroare. Apoi va lua valoarea data de accept pe al doilea argument (pentru a putea face asignari de genul x = x + 1
