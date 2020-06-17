package sun.enumeration.basics;

public enum OzWitch {
	// Instances must be defined first, before methods:
	ARIES("Positive characteristics: brave, sincere, dynamic, freedom-lovin spontaneous, adventurous and able to take initiatives, inspires others, childlike enthusiasm\n"
	+"Negative or weak aspects: hurrying to do things, egoism, demanding things instantly, reacting fast"),
TAURAUS("Positive characteristics: friendly, high bearing capacity, strong willpower, developed sense of aesthetics, strong instincts, patient\n"
+"Negative or weak aspects: stubborn, comfort loving, lazy, greedy, not flexible, possessive"),
	GEMINI("Positive characteristics: intellectual, logical, quick grasping, talented in writing and communication, talkative, joyful, full of knowledge\n"+
"Negative or weak aspects: changing, indecisive, two-faced, artificial, greedy, emotionally insufficient, gossiping, critical"),
	CANCER("Positive characteristics: empathy, motherhood, protective, sacrificing and receptive to other people’s needs, strong intuition\n"+
"Negative or weak aspects: over emotional, offended easily, changing, worries a lot, restless"),
	LEO("Positive characteristics: noble, expanded thinking, generous, self confident, inspiring, artistic\n"
+"Negative or weak aspects: egoistical, intolerant, vain"),
	VIRGO("Positive characteristics: brave, sincere, dynamic, freedom loving, spontaneous, adventurous, takes initiatives, inspiring, childlike enthusiasm\n"
+"Negative or weak aspects: rushing into things, ego, demanding everything immediately, reacting"),
	LIBRA("Positive characteristics: brave, sincere, dynamic, freedom loving, spontaneous, adventurous, takes initiatives, inspiring, childlike enthusiasm\n"
+"Negative or weak aspects: rushing into things, ego, demanding everything immediately, reacting"),
	SCORPIO("Positive characteristics: power to transform themselves, deep perception, intuition, bearing and determined, ability to influence others\n"
+"Negative or weak aspects: jealousy, possessiveness, holding grudges, doubtfullness, indulgence in power"),
	SAGITTARIUS("Positive characteristics: open to new things, understanding, generous, philosophical, optimistic, faithful in God, freedom loving and enthusiastic\n"
+"Negative or weak aspects: dogmatic, fanatic, not careful in speech, exaggerating"),
	CAPCRIOCON("Positive characteristics: withstands difficulties, trustworthy, patient, determined, organized\n"
+"Negative or weak aspects: stubborn, pessimistic, doesn’t like to spend money, materialistic, likes being in high positions"),
	AQUARIUS("Positive characteristics: humane, visionary, progressive, objective, rational and scientific, good at socializing\n"
+"Negative or weak aspects: rejects tradition, tries to be different, restless and rebellious"),
	PISCES ("Positive characteristics: sensitive, compassionate, strong imagination, artistic inspiration, creative, good at heart, faith in God\n"
+"Negative or weak aspects: lack of will power, indecisive, lacking in self confidence, dreamy, avoids reality, feels sorry for himself");
	private String description;
	// Constructor must be package or private access:
	private OzWitch(String description) {
	this.description = description;
	}
	public String getDescription() { return description; }
	}