import unittest

from probs.prob02_algospot_pi.pi_integratedLevel import integratedLevel


class ArithmeticSequenceTestCase(unittest.TestCase):
    def test_1(self):
        self.assertEqual(integratedLevel('000', 3), 1)

    def test_2(self):
        self.assertEqual(integratedLevel('123', 3), 2)

    def test_3(self):
        self.assertEqual(integratedLevel('232', 3), 4)

    def test_4(self):
        self.assertEqual(integratedLevel('147', 3), 5)

    def test_5(self):
        self.assertEqual(integratedLevel('139', 3), 10)

    # length4
    def test_length4_1(self):
        self.assertEqual(integratedLevel('0000', 4), 1)

    def test_length4_2(self):
        self.assertEqual(integratedLevel('1234', 4), 2)

    def test_length4_3(self):
        self.assertEqual(integratedLevel('2323', 4), 4)

    def test_length4_4(self):
        self.assertEqual(integratedLevel('1357', 4), 5)

    def test_length4_5(self):
        self.assertEqual(integratedLevel('1390', 4), 10)

    # length5
    def test_length5_1(self):
        self.assertEqual(integratedLevel('00000', 5), 1)

    def test_length5_2(self):
        self.assertEqual(integratedLevel('12345', 5), 2)

    def test_length5_3(self):
        self.assertEqual(integratedLevel('23232', 5), 4)

    def test_length5_4(self):
        self.assertEqual(integratedLevel('13579', 5), 5)

    def test_length5_5(self):
        self.assertEqual(integratedLevel('13901', 5), 10)
