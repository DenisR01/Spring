-- Inserarea întrebărilor și răspunsurilor

-- Întrebarea 1
INSERT INTO questions (text, category) VALUES
('Nu este permis unui autovehicul să circule atunci când:', 'Legislație rutieră');

SET @q1 = 1;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q1, 'poluează fonic, în timpul mersului sau staționării, peste pragul admis de lege;', TRUE),
(@q1, 'nu este dotat cu roată de rezervă;', FALSE),
(@q1, 'plăcuțele cu numărul de înmatriculare sunt deteriorate.', TRUE);

-- Întrebarea 2
INSERT INTO questions (text, category) VALUES
('Inspecția tehnică periodică a autovehiculelor / tractoarelor agricole sau forestiere și a remorcilor trebuie efectuată:', 'Legislație rutieră');

SET @q2 = 2;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q2, 'anual, la orice service auto;', FALSE),
(@q2, 'periodic, conform legii;', TRUE),
(@q2, 'la cel mult doi ani, la o stație de inspecție tehnică autorizată.', FALSE);

-- Întrebarea 3
INSERT INTO questions (text, category) VALUES
('Care dintre următoarele manevre, efectuate pe drumul public de către conducătorul de vehicul, sunt considerate a fi comportament agresiv?', 'Legislație rutieră');

SET @q3 = 3;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q3, 'deplasarea succesivă de pe o bandă de circulație pe alta sau de pe un rând pe altul, alternând din stânga în dreapta, în scopul depășirii unui șir de vehicule care circulă în același sens;', TRUE),
(@q3, 'depășirea pe partea dreaptă a vehiculului care a semnalizat intenția și s-a încadrat corespunzător părăsirii sensului de mers spre stânga;', FALSE),
(@q3, 'realizarea intenționată a unui derapaj controlat al vehiculului în vederea întoarcerii sau rotirii acestuia;', TRUE);

-- Întrebarea 4
INSERT INTO questions (text, category) VALUES
('Conducătorilor de autovehicule le este interzis:', 'Legislație rutieră');

SET @q4 = 4;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q4, 'să transporte în și pe autoturism obiecte a căror lungime sau lățime depășește, împreună cu încărcătura, dimensiunile acestuia;', TRUE),
(@q4, 'să aibă aplicate folii sau tratamente chimice pe parbrize, lunetă ori geamuri laterale, care reduc vizibilitatea;', TRUE),
(@q4, 'să circule cu vehiculele avariate mai mult de 30 de zile.', TRUE);

-- Întrebarea 5
INSERT INTO questions (text, category) VALUES
('Unui autovehicul / tractor agricol sau forestier nu-i este permis să circule atunci când:', 'Legislație rutieră');

SET @q5 = 5;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q5, 'unul dintre faruri nu funcționează;', FALSE),
(@q5, 'parbrizul este fisurat;', FALSE),
(@q5, 'noxele emanate depășesc limita legală admisă.', TRUE);

-- Întrebarea 6
INSERT INTO questions (text, category) VALUES
('Ce le este interzis conducătorilor de autovehicule și de tramvaie?', 'Legislație rutieră');

SET @q6 = 6;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q6, 'să folosească telefoanele mobile în timpul mersului, fără să aibă sistem de tip „mâini libere“;', TRUE),
(@q6, 'să folosească luminile de avarie în localități;', FALSE),
(@q6, 'să se angajeze în discuții cu alți pasageri.', FALSE);

-- Întrebarea 7
INSERT INTO questions (text, category) VALUES
('Încărcătura unui vehicul trebuie să fie așezată și, la nevoie, fixată astfel încât:', 'Siguranță rutieră');

SET @q7 = 7;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q7, 'să nu fie târâtă, să nu se scurgă și să nu cadă pe drum;', TRUE),
(@q7, 'să nu stânjenească vizibilitatea conducătorului și să nu pericliteze stabilitatea ori conducerea vehiculului;', TRUE),
(@q7, 'să nu provoace zgomot care să jeneze conducătorul, participanții la trafic ori să sperie animalele și să nu producă praf sau mirosuri pestilențiale.', TRUE);

-- Întrebarea 8
INSERT INTO questions (text, category) VALUES
('Aveți posibilitatea de a circula pe drumurile publice cu vehiculul avariat:', 'Legislație rutieră');

SET @q8 = 8;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q8, 'cel mult 10 zile de la data constatării evenimentului;', FALSE),
(@q8, 'până la expirarea asigurării obligatorii de răspundere civilă auto;', FALSE),
(@q8, 'cel mult 30 zile de la data producerii avariei.', TRUE);

-- Întrebarea 9
INSERT INTO questions (text, category) VALUES
('În care dintre situații este interzis să circulați pe drumurile publice?', 'Legislație rutieră');

SET @q9 = 9;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q9, 'atunci când certificatul de înmatriculare este deteriorat;', FALSE),
(@q9, 'atunci când vehiculul nu este asigurat de răspundere civilă, în caz de pagube materiale produse terților prin accidente de circulație, conform legii;', TRUE),
(@q9, 'atunci când conducătorul auto nu a plătit taxa de folosire a drumurilor publice.', FALSE);

-- Întrebarea 10
INSERT INTO questions (text, category) VALUES
('Cum se definește corect autovehiculul din categoria B?', 'Legislație rutieră');

SET @q10 = 10;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q10, 'autovehiculul care nu depășește 5.000 kg, al cărui număr de locuri pe scaune, în afara conducătorului, este mai mic de 8;', FALSE),
(@q10, 'autovehiculul care nu depășește 3.500 kg, al cărui număr de locuri pe scaune, în afara conducătorului, nu este mai mare de 8;', TRUE),
(@q10, 'autovehiculul care nu depășește 3.500 kg, al cărui număr de locuri pe scaune, în afara conducătorului, nu este mai mare de 5.', FALSE);

-- Întrebarea 11
INSERT INTO questions (text, category) VALUES
(' Prin comportament agresiv al conducătorului auto pe drumurile publice se înțelege efectuarea uneia dintre următoarele manevre:', 'Legislație rutieră');

SET @q11 = 11;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q11, 'Conducerea mopedului sau motocicletei fără a purta cască de protecție; ', FALSE),
(@q11, 'Mersul cu spatele cu vehiculul în scopul intimidării celorlalți participanți la trafic care circulă în spatele acestuia', TRUE),
(@q11, ' Realizarea intenționată a unui derapaj controlat al vehiculului în vederea întoarcerii sau rotirii acestuia.', TRUE);

-- Întrebarea 12
INSERT INTO questions (text, category) VALUES
(' Se interzice circulația pe drumurile publice a autovehiculului dacă:', 'Legislație rutieră');

SET @q12 = 12;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q12, ' mecanismul de direcție prezintă uzuri peste limitele admise; ', TRUE),
(@q12, ' autovehiculul are aplicate inscripții, desene, semne distinctive sau reclame de natură să împiedice ori să diminueze eficacitatea dispozitivelor de iluminare și de semnalizare luminoasă sau citirea numărului de înmatriculare; ' , TRUE),
(@q12, ' autovehiculul are montate accesorii pe parbrize ori pe geamurile laterale, care restrâng sau estompează vizibilitatea conducătorului în timpul mersului.', TRUE);

-- Întrebarea 13
INSERT INTO questions (text, category) VALUES
(' Copiii cu vârste de până la 12 ani pot fi transportați:', 'Legislație rutieră');

SET @q13 = 13;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q13, ' pe scaunul din față al autovehiculului, dacă sunt ținuți în brațe de persoane majore; ', FALSE),
(@q13, ' pe scaunul din față al autovehiculului, având fixată centura de siguranță;' , FALSE),
(@q13, ' pe bancheta din spate a autovehiculului, având fixată centura de siguranță, adaptată greutății și dimensiunilor lor.', TRUE);
-- Întrebarea 14
INSERT INTO questions (text, category) VALUES
('Vă este permis să claxonati un biciclist înainte de a-l depăși?', 'Conducere preventivă');

SET @q14 = 14;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q14, 'da, dacă distanța este de peste 25 m;', TRUE),
(@q14, 'nu;', FALSE),
(@q14, 'numai în reprize foarte scurte;', FALSE);

-- Întrebarea 15
INSERT INTO questions (text, category) VALUES
('Ce pericole pot apărea prin nefolosirea centurii de siguranță?', 'Conducere preventivă');

SET @q15 = 15;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q15, 'chiar și la o viteză de coliziune de aproximativ 20 km/h, există riscul unei accidentări;', TRUE),
(@q15, 'pericolele pot apărea la o viteză de peste 60 km/h;', FALSE),
(@q15, 'pericolul de accidentare este exclus;', FALSE);

-- Întrebarea 16
INSERT INTO questions (text, category) VALUES
('Ce înseamnă să conduceți preventiv pe timp nefavorabil?', 'Conducere preventivă');

SET @q16 = 16;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q16, 'să respectați cu strictete limitele de viteză pentru sectorul de drum pe care circulați;', FALSE),
(@q16, 'să reduceți viteza până la limita la care să vă asigurați o bună vizibilitate și un control deplin asupra comenzilor;', TRUE),
(@q16, 'să rulați cât mai aproape de axul drumului;', FALSE);

-- Întrebarea 17
INSERT INTO questions (text, category) VALUES
('Cum trebuie să procedați atunci când un autobuz școlar oprește cu luminile de avarie aprinse?', 'Conducere preventivă');

SET @q17 = 17;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q17, 'luminile intermitente de avertizare ale autobuzelor școlare vă obligă să opriți;', FALSE),
(@q17, 'circulați cu atenție sporită;', TRUE),
(@q17, 'nu aveți nicio obligație;', FALSE);

-- Întrebarea 18
INSERT INTO questions (text, category) VALUES
('Care este cea mai vulnerabilă categorie de participanți la trafic, din rândul căreia se înregistrează cele mai multe victime?', 'Conducere preventivă');

SET @q18 = 18;

INSERT INTO answers (question_id, text, is_correct) VALUES
(@q18, 'conductorii de vehicule fără experiență în conducere;', FALSE),
(@q18, 'conductorii de vehicule cu atestat profesional;', FALSE),
(@q18, 'pietonii, îndeosebi copiii și persoanele în vârstă;', TRUE);

-- Întrebarea 19
INSERT INTO questions (text, image_url, category) VALUES
('Schimbarea directiei de mers la dreapta sau la stanga nu este permisa la intalnirea :', 'https://www.scoalarutiera.ro/upload/img/questions/img/Cat_B_poz_1021.jpg', 'Indicatoare si marcaje');
SET @q19 = 19;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q19, 'Indicatorului 1', FALSE),
(@q19, 'Indicatorului 2', TRUE),
(@q19, 'Ambelor indicatoare', FALSE);

-- Întrebarea 20
INSERT INTO questions (text, category) VALUES
('Cum sunt semnalizate benzile de circulație reversibilă, care vă permit să continuați deplasarea?', 'Indicatoare si marcaje');
SET @q20 = 20;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q20, 'cu dispozitive de culoare galbenă intermitentă', FALSE),
(@q20, 'cu semnul roșu în cruce', FALSE),
(@q20, 'cu semnalul verde de forma unei săgeți cu vârful în jos', TRUE);

-- Întrebarea 21
INSERT INTO questions (text, image_url, category) VALUES
('Ce obligații aveți la întâlnirea indicatorului?', 'https://www.drpciv-teste.ro/images/sections/3466.jpg', 'Indicatoare si marcaje');
SET @q21 = 21;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q21, 'să nu depășiți viteza de 50km/h, deoarece urmează o curbă deosebit de periculoasă spre dreapta', TRUE),
(@q21, 'să reduceți viteza până la 40km/h și să circulați cu faza de întâlnire', FALSE),
(@q21, 'să nu depășiți vehiculele de transport de mărfuri', FALSE);

-- Întrebarea 22
INSERT INTO questions (text, image_url, category) VALUES
('Indicatorul alăturat te atenționează că:', 'https://www.drpciv-teste.ro/images/sections/9610.jpg', 'Indicatoare si marcaje');
SET @q22 = 22;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q22, 'te apropii de o trecere la nivel cu calea ferată cu barieră', FALSE),
(@q22, 'este posibilă o blocare a drumului', FALSE),
(@q22, 'te apropii de un pod mobil', TRUE);

-- Întrebarea 23
INSERT INTO questions (text, image_url, category) VALUES
('Panoul de sub indicator perminte', 'https://www.scoalarutiera.ro/upload/img/questions/img/Cat_B_poz_1035.jpg', 'Indicatoare si marcaje');
SET @q23 = 23;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q23, 'Stationarea mijloacelor de transport public de personae in intervalul mentionat', FALSE),
(@q23, 'Stationarea in timpul orelor mentionate', FALSE),
(@q23, 'Stationarea in afara inervalului orar mentionat', TRUE);

-- Întrebarea 24
INSERT INTO questions (text, image_url, category) VALUES
('Care dintre urmatoarele indicatoare te avertizeaza ca urmeaza sa intersectezi un drum fara prioritate?', 'https://www.scoalarutiera.ro/upload/img/questions/img/Cat_B_poz_978.jpg', 'Indicatoare si marcaje');
SET @q24 = 24;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q24, 'Ambele', FALSE),
(@q24, 'Indicatorul 1', TRUE),
(@q24, 'Indicatorul 2', FALSE);

-- Întrebarea 25
INSERT INTO questions (text, image_url, category) VALUES
('Care dintre indicatoarele alaturate creeaza obligatii pentru conducatorii de vehicule auto?', 'https://www.scoalarutiera.ro/upload/img/questions/img/Cat_B_poz_192.jpg', 'Indicatoare si marcaje');
SET @q25 = 25;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q25, 'Indicatorul 1', TRUE),
(@q25, 'Indicatorul 2', FALSE),
(@q25, 'Nici unul dintre aceste indicatoare', FALSE);

-- Întrebarea 26
INSERT INTO questions (text, image_url, category) VALUES
('La intalnirea panoului de pe stalp aveti obligatia:', 'https://www.scoalarutiera.ro/upload/img/questions/img/Cat_B_poz_331.jpg', 'Indicatoare si marcaje');
SET @q26 = 26;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q26, 'să vă deplasați cu atenție pe sectorul de drum îngustat', TRUE),
(@q26, 'să acordați prioritate numai autocamioanelor și autobuzelor care circulă din sens opus', FALSE),
(@q26, 'să acordați prioritate vehiculelor care circulă din sens opus', FALSE);

-- Întrebarea 27
INSERT INTO questions (text, category) VALUES
('Marcajul aplicat pe marginea din dreapta a părții carosabile, format dintr-o linie în zig-zag, semnifică:', 'Indicatoare si marcaje');
SET @q27 = 27;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q27, 'interzicerea staționării', TRUE),
(@q27, 'interzicerea opririi', FALSE),
(@q27, 'alte pericole', FALSE);

-- Întrebarea 28
INSERT INTO questions (text, image_url, category) VALUES
('Indicatorul interzice accesul', 'https://www.scoalarutiera.ro/upload/img/questions/img/Cat_B_poz_739.jpg', 'Indicatoare si marcaje');
SET @q28 = 28;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q28, 'autoturismelor, motocicletelor fără ataș și vehiculelor cu tracțiune animală', FALSE),
(@q28, 'autovehiculelor și vehiculelor cu tracțiune animală', TRUE),
(@q28, 'autoturismelor, motocicletelor și vehiculelor împinse sau trase cu mâna', FALSE);

-- Întrebarea 29
INSERT INTO questions (text, image_url, category) VALUES
('Indicatorul vă avertizează că urmează:', 'https://www.scoalarutiera.ro/upload/img/questions/img/Cat_B_poz_801.jpg', 'Indicatoare si marcaje');
SET @q29 = 29;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q29, 'un drum cu denivelări', FALSE),
(@q29, 'un segment de drum pe care se execută lucrări de amenajare', FALSE),
(@q29, 'o denivelare pentru limitarea vitezei', TRUE);

-- Întrebarea 30
INSERT INTO questions (text, category) VALUES
('În cazul unui accident în care victima și-a pierdut cunoștința, prima măsură va fi', 'Masuri de prim ajutor');
SET @q30 = 30;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q30, 'să controlați respirația și bătăile inimii', TRUE),
(@q30, 'să administrați medicamente din trusa de prim ajutor', FALSE),
(@q30, 'să imobilizați eventualele fracturi', FALSE);

-- Întrebarea 31
INSERT INTO questions (text, category) VALUES
('Hemoragia nazală se poate opri dacă accidentatul', 'Masuri de prim ajutor');
SET @q31 = 31;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q31, 'stă în picioare și își strânge ambele nări timp de aproximativ 5-10 minute', TRUE),
(@q31, 'stă culcat cu capul pe spate', FALSE),
(@q31, 'ridică mâna dreaptă', FALSE);

-- Întrebarea 32
INSERT INTO questions (text, category) VALUES
('Imobilizarea unui braț fracturat se face', 'Masuri de prim ajutor');
SET @q32 = 32;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q32, 'în dreptul osului fracturat', FALSE),
(@q32, 'cuprinzând osul fracturat și articulația superioară', FALSE),
(@q32, 'cuprinzând osul fracturat și cele două articulații, respectiv cea superioară și inferioară', TRUE);

-- Întrebarea 33
INSERT INTO questions (text, category) VALUES
('Ce trebuie să conțină biletul care se prinde lângă garoul aplicat unei persoane rănite', 'Masuri de prim ajutor');
SET @q33 = 33;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q33, 'datele de stare civilă ale persoanei', FALSE),
(@q33, 'poziția în care a fost găsită victima', FALSE),
(@q33, 'ora și minutul aplicării garoului', TRUE);

-- Întrebarea 34
INSERT INTO questions (text, category) VALUES
('Cum trebuie așezată într-un mijloc de transport o persoană rănită, care prezintă leziuni ale coloanei vertebrale', 'Masuri de prim ajutor');
SET @q34 = 34;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q34, 'în poziție șezândă', FALSE),
(@q34, 'orizontal, cu fața în sus', FALSE),
(@q34, 'persoana nu trebuie mișcată până la sosirea ambulanței', TRUE);

-- Întrebarea 35
INSERT INTO questions (text, category) VALUES
('O hemoragie produsă la unul dintre membrele unei persoane rănite se va opri prin', 'Masuri de prim ajutor');
SET @q35 = 35;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q35, 'dezinfecția rănii, pansarea și aplicarea ateletor', FALSE),
(@q35, 'ridicarea membrului accidentat în poziție verticală', FALSE),
(@q35, 'acțiunea compresivă asupra vasului lezat sau aplicarea garoului', TRUE);

-- Întrebarea 36
INSERT INTO questions (text, category) VALUES
('Victima care a pierdut mult sânge trebuie să fie așezată', 'Masuri de prim ajutor');
SET @q36 = 36;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q36, 'cu fața în sus', FALSE),
(@q36, 'cu fața în jos', FALSE),
(@q36, 'cu picioarele situate mai sus decât nivelul corpului', TRUE);

-- Întrebarea 37
INSERT INTO questions (text, category) VALUES
('Ce trebuie să faceți pentru evitarea complicațiilor în cazul unei fracturi', 'Masuri de prim ajutor');
SET @q37 = 37;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q37, 'să imobilizați zona fracturată', TRUE),
(@q37, 'să sterilizați și să pansați zona fracturată', FALSE),
(@q37, 'să aplicați un garou de cauciuc deasupra fracturii', FALSE);

-- Întrebarea 38
INSERT INTO questions (text, category) VALUES
('Gravitatea unei hemoragii se apreciază în funcție de', 'Masuri de prim ajutor');
SET @q38 = 38;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q38, 'cantitatea sângelui pierdut', TRUE),
(@q38, 'culoarea sângelui scurs', FALSE),
(@q38, 'fluiditatea sângelui scurs', FALSE);

-- Întrebarea 39
INSERT INTO questions (text, category) VALUES
('Bandajele se folosesc', 'Masuri de prim ajutor');
SET @q39 = 39;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q39, 'pentru susținerea părților lezate', FALSE),
(@q39, 'pentru acoperirea și pentru susținerea rănilor, precum și pentru oprirea hemoragiilor', TRUE),
(@q39, 'pentru imobilizarea fracturilor', FALSE);

-- Întrebarea 40
INSERT INTO questions (text, category) VALUES
('În cazul unui accident cu victime și cu deformarea accentuată a caroseriei, procedați la', 'Masuri de prim ajutor');
SET @q40 = 40;
INSERT INTO answers (question_id, text, is_correct) VALUES
(@q40, 'victimele conștiente sunt sfătuite să nu se miște, iar degajarea acestora trebuie să se realizeze cât mai repede și numai de către echipaje specializate', TRUE),
(@q40, 'degajarea victimelor trebuie să se realizeze cât mai repede, prin orice mijloace', FALSE),
(@q40, 'se administrează calmante victimelor care sunt conștiente', FALSE);