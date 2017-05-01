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
ce s-ar putea sa dea eroare. Apoi va lua valoarea data de accept pe al doilea argument (pentru a putea face asignari de genul x = x + 1) si le va introduce in tabela de valori.

AssertNode, visit pe acest nod va lua valoarea data de acceptul pe copilul lui si verifica daca este 0 sau 1.

IfNode, va verifica valoarea data de accept pe primul argument, care este conditia. Daca este 1, atunci se va da accept pe al doilea 
argument. Daca este 0, atunci se va da accept pe al treilea argument. Accept pe aceste argumente le vor rula normal.

ForNode, va da accept pe primul argument, ce va fi un AssignNode si va construi un while. Cat timp accept pe conditia data de al 
doilea argument va fi adevarata, se vor da accept pe al treilea argument (incrementarea) si pe al patrulea argument.

ReturnNode, va seta valoarea de return_value din visitor cu valoarea data de accept pe copilul acestuia. Valoarea aceasta va fi scrisa 
la finalul programului in fisier in Expression.

NothingNode, este nodul pentru secventa pe program. Acceptul acestuia va da accept pe toate nodurile din lista de copii.

Pentru tratarea erorilor se foloseste un array de 3 elemente cu flaguri.

Pentru Check failed, daca se face accept pe un ArgumentNode ce contine un simbol, iar acesta nu este gasit ca si cheie in HashMapul 
valueTable, atunci vom seta flags[0] cu 1. De asemenea nu are rost sa se mai face vreo operatie dupa acest Check Failed asa ca nu se 
va apela nici un accept sau visit daca acest flag este 1.

Pentru Assert Failed, cand se va intalni un assert a carui visit pe acesta va returna 0, flag[1] va fi setat la 1. Executia 
programului va continua neintrupta, deoare trebuie verifica si missing return inainte de Assert Failed si pentru aceasta va trebui sa
se ajunga la finalul programului.

Pentru Missing Return, se va verifica daca flags[2] este 0. In visit(ReturnNode), flagul lui visitor este setat la 1, si valoarea de 
return setata. Daca se va ajunge la finalul programului si flags[2] este 0, atunci nu s-a ajuns niciodata in visit(ReturnNode), deci nu a existat unul in program.

La finalul acceptului treeului mare, se va verifica pe rand fiecare dintre aceste flaguri ale visitorului in ordinea prioritatii lor, 
si se scrie mesajul corespunzator daca exista eroare sau valoarea daca nu exista erori.  
