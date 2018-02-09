import unittest

from prob02_algospot_pi.pi import simpleIncrease


class SimpleIncreaseTestCase(unittest.TestCase):
    def test_simpleIncrease_1(self):
        self.assertEqual(simpleIncrease('123'), True)

    def test_simpleIncrease_2(self):
        self.assertEqual(simpleIncrease('1234'), True)

    def test_simpleIncrease_3(self):
        self.assertEqual(simpleIncrease('12345'), True)

    def test_simpleIncrease_4(self):
        self.assertEqual(simpleIncrease('234'), True)

    def test_simpleIncrease_5(self):
        self.assertEqual(simpleIncrease('012'), True)

    def test_simpleIncrease_6(self):
        self.assertEqual(simpleIncrease('121'), False)

    def test_simpleIncrease_7(self):
        self.assertEqual(simpleIncrease('1231'), False)

    def test_simpleIncrease_8(self):
        self.assertEqual(simpleIncrease('12341'), False)


    def test_simpleDecrease_1(self):
        self.assertEqual(simpleIncrease('321'), True)

    def test_simpleDecrease_2(self):
        self.assertEqual(simpleIncrease('4321'), True)

    def test_simpleDecrease_3(self):
        self.assertEqual(simpleIncrease('54321'), True)

    def test_simpleDecrease_4(self):
        self.assertEqual(simpleIncrease('432'), True)

    def test_simpleDecrease_5(self):
        self.assertEqual(simpleIncrease('210'), True)

    def test_simpleDecrease_6(self):
        self.assertEqual(simpleIncrease('212'), False)

    def test_simpleDecrease_7(self):
        self.assertEqual(simpleIncrease('3213'), False)

    def test_simpleDecrease_8(self):
        self.assertEqual(simpleIncrease('43214'), False)